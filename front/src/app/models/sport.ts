export class Sport{
  constructor(private _id:number,
  private _name:string,
  private _description:string,
  private _icon:string,
  private _active:boolean,
  private _nbEvents:number,
  private _nbUsers:number) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get icon(): string {
    return this._icon;
  }

  set icon(value: string) {
    this._icon = value;
  }

  get active(): boolean {
    return this._active;
  }

  set active(value: boolean) {
    this._active = value;
  }

  get nbEvents(): number {
    return this._nbEvents;
  }

  set nbEvents(value: number) {
    this._nbEvents = value;
  }

  get nbUsers(): number {
    return this._nbUsers;
  }

  set nbUsers(value: number) {
    this._nbUsers = value;
  }
}
