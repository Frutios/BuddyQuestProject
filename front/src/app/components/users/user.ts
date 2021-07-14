export class User {
    private _id!: number;
    private _firstName!: string;
    private _lastName!: string;
    private _phone!: string;
    private _pseudonym!: string;
    private _password!: string;
    private _email!: string;
    private _inscritptionDate!: Date;
    private _urlAvatar!: string;
    private _description!: string;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }

  get pseudonym(): string {
    return this._pseudonym;
  }

  set pseudonym(value: string) {
    this._pseudonym = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get inscritptionDate(): Date {
    return this._inscritptionDate;
  }

  set inscritptionDate(value: Date) {
    this._inscritptionDate = value;
  }

  get urlAvatar(): string {
    return this._urlAvatar;
  }

  set urlAvatar(value: string) {
    this._urlAvatar = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get fullName(): string{
    return this._firstName + " " + this._lastName;;
  }
}
